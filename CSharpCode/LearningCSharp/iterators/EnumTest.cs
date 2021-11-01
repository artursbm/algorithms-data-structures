using System;
using System.Collections.Generic;
using System.Linq;

namespace LearningCSharp.iterators
{
    public enum EnumTest
    {
        Pending = 1,
        Accepted = 2,
        Protested = 3
    }

    public static class EnumTestUtil
    {
        public static IEnumerable<EnumTest> GetEnums()
        {
            foreach (var en in Enum.GetValues(typeof(EnumTest)).Cast<EnumTest>())
            {
                if (en != EnumTest.Pending)
                {
                    yield return en;
                }
            }
        }
    }
}