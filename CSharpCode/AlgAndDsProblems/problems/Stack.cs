namespace AlgAndDsProblems.problems
{
    public class Stack
    {
        private StackItem top;
        
        private void pushCharacter(char c)
        {
            if (top == null)
            {
                top = new StackItem(c);
            }
            else
            {
                var b = top;
                top = new StackItem(c) { bottom = b };
            }
        }

        private char popCharacter()
        {
            var c = top.data;
            top = top.bottom;
            return c;
        }

        private char peek()
        {
            return top.data;
        }
    }
    
    internal class StackItem
    {
        public char data;
        public StackItem bottom;

        public StackItem(char d)
        {
            bottom = null;
            data = d;
        }
    }
}