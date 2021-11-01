namespace AlgAndDsProblems.problems
{
    public class Queue
    {
        private QueueElement first;
        
        private void enqueueCharacter(char c)
        {
            if (first == null)
            {
                first = new QueueElement(c);
            }
            else
            {
                enqueueNext(first, c);
            }
        }

        private void enqueueNext(QueueElement elem, char c)
        {
            if (elem.next == null)
            {
                elem.next = new QueueElement(c);
            }
            else
            {
                enqueueNext(elem.next, c);
            }
        }

        private char dequeueCharacter()
        {
            var fc = first.data;
            first = first.next;
            return fc;
        }
    }

    internal class QueueElement
    {
        public char data;
        public QueueElement next;

        public QueueElement(char d)
        {
            data = d;
            next = null;
        }
    }
}