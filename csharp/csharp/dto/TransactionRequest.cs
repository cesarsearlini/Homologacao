using csharp.enums;
using System.Collections.Generic;

namespace csharp.dto
{
    class TransactionRequest
    {
        private int installment = 1;
        private double value;
        private CardApplication cardApplication;
        private TenantPlanMode tenantPlanMode = TenantPlanMode.DISABLED;
        private List<BinRange> binRange = new List<BinRange>();

        public int Installment
        {
            get { return installment; }
            set { installment = value; }
        }

        public double Value
        {
            get { return value; }
            set { this.value = value; }
        }

        public CardApplication CardApplication
        {
            get { return cardApplication; }
            set { cardApplication = value; }
        }

        public TenantPlanMode TenantPlanMode
        {
            get { return tenantPlanMode; }
            set { tenantPlanMode = value; }
        }

        public List<BinRange> BinRange
        {
            get { return binRange; }
            set { binRange = value; }
        }

    }
}