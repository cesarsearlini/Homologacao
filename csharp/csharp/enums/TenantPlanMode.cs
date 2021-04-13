namespace csharp.enums
{
    enum TenantPlanMode
    {
        DISABLED,
        TENANT,
        MDR_0
    }

    static class TenantPlanModeExtension
    {
        internal static string GetDescription(TenantPlanMode tenantPlanMode)
        {
            switch (tenantPlanMode)
            {
                case TenantPlanMode.MDR_0:
                    return "MDR-0 CRÉDITO/DEBITO";
                case TenantPlanMode.TENANT:
                    return "Lojista e Portador";
                default:
                    return "Desativar";
            }
        }

        internal static TenantPlanMode GetTenantPlanMode(string tenantPlanMode)
        {
            switch (tenantPlanMode)
            {
                case "MDR-0 CRÉDITO/DEBITO":
                    return TenantPlanMode.MDR_0;
                case "Lojista e Portador":
                    return TenantPlanMode.TENANT;
                default:
                    return TenantPlanMode.DISABLED;
            }
        }
    }
}
