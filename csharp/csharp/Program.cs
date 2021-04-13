using csharp;
using csharp.dto;
using csharp.enums;
using System;

namespace csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            Charge();
        }

        internal static void Charge()
        {
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.CardApplication = CardApplication.CREDITO;
            transactionRequest.TenantPlanMode = TenantPlanMode.DISABLED;
            transactionRequest.Value = 20.5;

            Operator transactionOperator = new Operator();
            StatusResponse statusResponse = transactionOperator.Start(transactionRequest);
            Loop(transactionOperator, statusResponse);
        }

        internal static void Revert(int transactionId)
        {
            Operator transactionOperator = new Operator();
            transactionOperator.Revert(transactionId);
        }

        internal static void Loop(Operator transactionOperator, StatusResponse statusResponse)
        {
            bool run = true;
            while (run)
            {
                switch ((TransactionStatus)statusResponse.status)
                {
                    case TransactionStatus.PROCESSING:
                    case TransactionStatus.PROCESSING_CHARGE:
                        statusResponse = transactionOperator.GetStatus();
                        break;
                    case TransactionStatus.WAITING_CHARGE:
                        statusResponse = transactionOperator.SendCharge(1);
                        break;
                    case TransactionStatus.SUCCESS:
                        Console.WriteLine(transactionOperator.GetReceipt());
                        run = false;
                        break;
                    case TransactionStatus.NOT_FOUND:
                    case TransactionStatus.INACTIVE:
                    default:
                        run = false;
                        break;
                }
            }
        }

    }
}
