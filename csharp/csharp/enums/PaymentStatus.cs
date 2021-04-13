namespace csharp.enums
{
    enum PaymentStatus
    {
        SUCCESS,
        PENDING,
        CANCELED,
        FAILED
    }

    static class PaymentStatusExtension
    {
        internal static string GetDescription(PaymentStatus paymentStatus)
        {
            switch (paymentStatus)
            {
                case PaymentStatus.SUCCESS:
                    return "Sucesso";
                case PaymentStatus.PENDING:
                    return "Pendente";
                case PaymentStatus.CANCELED:
                    return "Cancelado";
                default:
                    return "Falha";
            }
        }

        internal static PaymentStatus GetPaymentStatus(string paymentStatus)
        {
            switch (paymentStatus)
            {
                case "Sucesso":
                    return PaymentStatus.SUCCESS;
                case "Pendente":
                    return PaymentStatus.PENDING;
                case "Cancelado":
                    return PaymentStatus.CANCELED;
                default:
                    return PaymentStatus.FAILED;
            }
        }
    }
}