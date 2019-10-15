package edu.uom;

public class HelloWorld {

    public String getMessage(){
        return "Hello World!!";
    }

    public  String getMessage(String name){
        if(name == null|| name.length()==0){
            return getMessage();
        }
        return "Hello " + name +"!!";
    }

    public  String getTimedMessage(TimeProvider timeProvider) {

        //check which time segment we are in
        int segment = timeProvider.getTimeSegment();

        switch (segment){
            case TimeProvider.MORNING:
                return "Hello World!! Good morning!";
                case TimeProvider.AFTERNOON:
                    return "Hello World!! Good afternoon!";
                    case TimeProvider.EVENING:
                        return "Hello World!! Good evening!";
                        default:
                            return "Hello world";

        }

    }

}
