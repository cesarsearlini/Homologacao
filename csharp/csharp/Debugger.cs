using System;

namespace csharp
{
    class Debugger
    {

        internal static bool enable = true;

        internal static void Log(Object o)
        {
            if (enable)
            {
                Console.WriteLine(o.ToString());
            }
        }

    }
}