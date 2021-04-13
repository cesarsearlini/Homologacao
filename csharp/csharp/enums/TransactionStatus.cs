namespace csharp.enums
{
    enum TransactionStatus
    {
        NOT_FOUND = -2,
        INACTIVE = -1,
        SUCCESS = 0,
        PROCESSING = 1,
        WAITING_CHARGE = 2,
        PROCESSING_CHARGE = 3
    }

}