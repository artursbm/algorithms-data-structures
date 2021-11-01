using System;
using System.Linq;

namespace AlgAndDsProblems.Models
{
    public class Person
    {
        protected string firstName;
        protected string lastName;
        protected int id;

        public Person()
        {
        }

        public Person(string firstName, string lastName, int identification)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = identification;
        }

        public void printPerson()
        {
            Console.WriteLine("Name: " + lastName + ", " + firstName + "\nID: " + id);
        }
    }

    public class Student : Person
    {
        private int[] testScores;

        /*	
        *   Class Constructor
        *   
        *   Parameters: 
        *   firstName - A string denoting the Person's first name.
        *   lastName - A string denoting the Person's last name.
        *   id - An integer denoting the Person's ID number.
        *   scores - An array of integers denoting the Person's test scores.
        */
        // Write your constructor here
        public Student(string firstName, string lastName, int id, int[] scores)
            : base(firstName, lastName, id)
        {
            testScores = scores;
        }

        /*	
        *   Method Name: Calculate
        *   Return: A character denoting the grade.
        */
        // Write your method here
        public char Calculate()
        {
            var avg = testScores.Average();
            if(avg >= 90 && avg <=100) return 'O';
            else if (avg >= 80 && avg < 90) return 'E';
            else if (avg >= 70 && avg < 80) return 'A';
            else if (avg >= 55 && avg < 70) return 'P';
            else if (avg >= 40 && avg < 55) return 'D';
            else if (avg < 40) return 'T';
            else throw new ArgumentOutOfRangeException($"Invalid {avg}");
            // return TransformAverage(avg);
        }

        private static char TransformAverage(double avg) => avg switch
        {
            >= 90 and <= 100 => 'O',
            >= 80 and < 90 => 'E',
            >= 70 and < 80 => 'A',
            >= 55 and < 70 => 'P',
            >= 40 and < 55 => 'D',
            < 40 => 'T',
            _ => throw new ArgumentOutOfRangeException(nameof(avg), avg, "Invalid grade.")
        };
    }
}