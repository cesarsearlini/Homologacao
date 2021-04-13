using csharp.enums;
using System;

namespace csharp.dto
{
    class TransactionResponse
    {
        public long transactionId { get; set; }
        public int status { get; set; }
        public PaymentStatus paymentStatus { get; set; }
        public String nsu { get; set; }
        public String nsuOriginal { get; set; }
        public String cardHiddenPan { get; set; }
        public String authorizationCode { get; set; }
        public String cardProductName { get; set; }
        public String merchant { get; set; }
        public String client { get; set; }
        public String merchantHtml { get; set; }
        public String clientHtml { get; set; }
        public CardApplication cardApplication { get; set; }
        public String cardHolderName { get; set; }
    }
}