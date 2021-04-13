namespace csharp.dto
{
    class InstallmentInfo
    {
        public string cardBrand { get; set; }
        public CardApplication cardApplication { get; set; }
        public int installment { get; set; }
        public decimal installmentValue { get; set; }
        public decimal total { get; set; }

    }
}