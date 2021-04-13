using System.Collections.Generic;

namespace csharp.dto
{
    class StatusResponse
    {
        public long id { get; set; }
        public int status { get; set; }
        public List<string> actions { get; set; }
        public string message { get; set; }
        public List<InstallmentInfo> installmentInfo { get; set; }
        public CardInfo cardInfo { get; set; }

    }
}