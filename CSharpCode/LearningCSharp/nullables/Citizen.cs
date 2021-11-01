using System;

namespace LearningCSharp.nullables
{
    public class Citizen
    {
        public Citizen(string firstName, string lastName, int? age, string? gender)
        {
            FirstName = firstName ?? throw new ArgumentNullException(nameof(firstName));
            LastName = lastName ?? throw new ArgumentNullException(nameof(lastName));
            Age = age;
            Gender = gender;
        }

        public string FirstName { get; set; }
        public string LastName { get; set; }
        public int? Age { get; set; }
        // nullable reference types should be enabled in .csproj file
        // this will enable the possibility of having nullable variables explicit
        // to the compiler and other programmers
        public string? Gender { get; set; }

    }
}
