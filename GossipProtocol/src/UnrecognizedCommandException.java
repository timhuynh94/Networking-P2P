public class UnrecognizedCommandException extends RuntimeException
		{
			/*
					Caleb D. Wolfe
					May 15, 2014

					This class will be an Exception for some Command that cannot be run

					Constructors:
						UnrecognizedCommandException()
							This will initialize the default message.

						UnrecognizedCommandException(String message)
							This will intialize the custom message.

					Modification:
						May 13, 2014
							Original Creation.
		*/
			public UnrecognizedCommandException()
			{
				this("Command is not Regonized");
			}
			public UnrecognizedCommandException(String error)
			{
				super(error);
			}

		}