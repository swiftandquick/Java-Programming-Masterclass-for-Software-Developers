package s7p95_Polymorphism;

class Movie {

    private String name;


    public Movie(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public String plot() {
        return "No plot here.  ";
    }

}



class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }


    public String plot() {
        return "A shark eats lots of people.  ";
    }

}



class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }


    @Override
    public String plot() {
        return "Aliens attempt to take over planet Earth.  ";
    }

}



class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze Runner");
    }


    @Override
    public String plot() {
        return "Kids try and escape a maze.  ";
    }

}



class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }


    @Override
    public String plot() {
        return "Imperial Forces try to take over the universe.  ";
    }

}



class Forgetable extends Movie {

    public Forgetable() {
        super("Forgetable");
    }

    // No plot method.

}



public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            /* Every time the loop iterates, a random object is assigned to the variable movie.
            * For example, Movie movie = new Jaws().  I create a Jaws object and store it in the Movie type variable
            * called movie, then I use the variable movie to invoke the plot() method in the Jaws class.  */
            Movie movie = randomMovie();
            /* movie.plot() is how polymorphism works.  */
            System.out.println("Movie #" + i + ":  " + movie.getName()
                            + "\n" + "Plot:  " + movie.plot() + "\n");
        }
    }


    /* Method returns a Movie object.  */
    public static Movie randomMovie() {
        /* Math.random() return a random number, so I have to convert it to int.  Return number from 1 to 5.  */
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was:  " + randomNumber);
        switch (randomNumber) {
            case 1:
                /* Returns a new unnamed object of the Jaws class, which is the subclass of Movie.  */
                return new Jaws();
                // No need to use break because return exits the method.
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
        }
        return null;
    }

}
