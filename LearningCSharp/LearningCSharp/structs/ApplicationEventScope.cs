namespace LearningCSharp.structs
{
    public readonly struct ApplicationEventScope
    {
        private  readonly string _operation;
        public static ApplicationEventScope Assignment => "Cessão de Recebíveis";
        
        private ApplicationEventScope(string operation)
        {
            _operation = operation;
        }
        
        public static implicit operator ApplicationEventScope(string operation)
        {
            return new ApplicationEventScope(operation);
        }

        public static implicit operator string(ApplicationEventScope applicationEventScope)
        {
            return applicationEventScope._operation;
        }

        public override string ToString()
        {
            return _operation;
        }

    }
}