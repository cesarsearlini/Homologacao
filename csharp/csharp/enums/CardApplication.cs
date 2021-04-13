namespace csharp.dto
{
    enum CardApplication
    {
        CREDITO,
        DEBITO
    }

    static class CardApplicationExtension
    {
        internal static string GetDescription(CardApplication cardApplication)
        {
            if (CardApplication.CREDITO == cardApplication)
            {
                return "Crédito";
            }
            else
            {
                return "Débito";
            }
        }


        internal static string GetCode(CardApplication cardApplication)
        {
            if (CardApplication.CREDITO == cardApplication)
            {
                return "01";
            }
            else
            {
                return "02";
            }
        }

        internal static CardApplication GetCardApplication(string cardApplication)
        {
            if (cardApplication == "01" || cardApplication == "Crédito")
            {
                return CardApplication.CREDITO;
            }
            else
            {
                return CardApplication.DEBITO;
            }
        }

    }

}