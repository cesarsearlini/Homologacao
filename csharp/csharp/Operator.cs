using csharp.dto;
using Newtonsoft.Json;
using System;
using System.IO;
using System.Net;

namespace csharp
{
    enum RequestType
    {
        GET, POST
    }

    class Operator
    {
        private const string BASE_URL = "http://localhost:12030/api/transaction";

        public StatusResponse Start(TransactionRequest transactionRequest)
        {          
            string url = BASE_URL + "/start";

            string payload = JsonConvert.SerializeObject(transactionRequest, Formatting.Indented);

            HttpWebRequest request = MakeRequest(url, RequestType.POST);

            using (StreamWriter swJsonPayload = new StreamWriter(request.GetRequestStream()))
            {
                swJsonPayload.Write(payload);
                swJsonPayload.Close();
            }

            string response = SendRequest(request);

            if (response != null)
            {
                return JsonConvert.DeserializeObject<StatusResponse>(response);
            }

            return null;
        }

        public StatusResponse GetStatus()
        {

            string url = BASE_URL + "/status";

            HttpWebRequest request = MakeRequest(url, RequestType.GET);

            string response = SendRequest(request);

            if (response != null)
            {
                return JsonConvert.DeserializeObject<StatusResponse>(response);
            }

            return null;
        }

        public StatusResponse SendCharge(int installment)
        {
            string url = BASE_URL + "/charge/" + installment;

            HttpWebRequest request = MakeRequest(url, RequestType.GET);

            string response = SendRequest(request);

            if (response != null)
            {
                return JsonConvert.DeserializeObject<StatusResponse>(response);
            }

            return null;
        }

        public StatusResponse Revert(int id)
        {
            string url = BASE_URL + "/revert/" + id;

            HttpWebRequest request = MakeRequest(url, RequestType.GET);

            string response = SendRequest(request);

            if (response != null)
            {
                return JsonConvert.DeserializeObject<StatusResponse>(response);
            }

            return null;
        }

        public TransactionResponse GetReceipt()
        {
            string url = BASE_URL + "/receipt/";

            HttpWebRequest request = MakeRequest(url, RequestType.GET);

            string response = SendRequest(request);

            if (response != null)
            {
                return JsonConvert.DeserializeObject<TransactionResponse>(response);
            }

            return null;
        }

        private HttpWebRequest MakeRequest(string url, RequestType requestType)
        {
            HttpWebRequest request = (HttpWebRequest)HttpWebRequest.Create(url);
            request.Method = requestType.ToString();
            request.ContentType = "application/json";
            return request;
        }

        private string SendRequest(HttpWebRequest request)
        {
            try
            {
                HttpWebResponse response = (HttpWebResponse)request.GetResponse();

                using (Stream responseStream = response.GetResponseStream())
                {
                    if (responseStream != null)
                    {
                        using (StreamReader reader = new StreamReader(responseStream))
                        {
                            string responseBody = reader.ReadToEnd();
                            Console.WriteLine(responseBody);
                            return responseBody;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                Debugger.Log(e);
            }

            return null;
        }

    }
}