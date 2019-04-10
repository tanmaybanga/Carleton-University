import java.util.ArrayList;

public class DVDCollection {

    private ArrayList<DVD>  dvds;
    private int             selectedDVD;


    public DVDCollection() {
        dvds = new ArrayList<DVD>();
        selectedDVD = -1;
    }

    public void setSelectedDVD(int i) {
        selectedDVD = i;
    }

    public ArrayList<DVD> getDvds() { return dvds; }

    public String toString() { return ("DVD Collection of size " + dvds.size()); }

    public void add(DVD aDvd) {
        dvds.add(aDvd);
    }
    public boolean remove(String title) {
        for (DVD d: dvds) {
            if (d.getTitle().equals(title)) {
                dvds.remove(d);
                return true;
            }
        }
        return false;
    }

    public void sortByTitle() {
        for (int p = 1; p<dvds.size(); p++) {
            DVD key = dvds.get(p);
            int i =  p - 1;
            while ((i >= 0) && (dvds.get(i).getTitle().compareTo(key.getTitle()) > 0)) {
                dvds.set(i+1, dvds.get(i));
                i = i - 1;
            }
            dvds.set(i+1, key);
        }
    }

    public void sortByYear() {
        for (int p = 1; p<dvds.size(); p++) {
            DVD key = dvds.get(p);
            int i =  p - 1;
            while ((i >= 0) && (dvds.get(i).getYear() > key.getYear())) {
                dvds.set(i+1, dvds.get(i));
                i = i - 1;
            }
            dvds.set(i+1, key);
        }
    }
    public void sortByLength() {
        for (int p = 1; p <dvds.size(); p++) {
            DVD key = dvds.get(p);
            int i =  p - 1;
            while ((i >= 0) && (dvds.get(i).getDuration() > key.getDuration())) {
                dvds.set(i+1, dvds.get(i));
                i = i - 1;
            }
            dvds.set(i+1, key);
        }
    }

    public DVD oldestDVD() {
        DVD     min = dvds.get(0);
        for (DVD d: dvds) {
            if (d.getYear() < min.getYear())
                min = d;
        }
        return min;
    }
    public DVD newestDVD() {
        DVD     max = dvds.get(0);
        for (DVD d: dvds) {
            if (d.getYear() > max.getYear())
                max = d;
        }
        return max;
    }
    public DVD shortestDVD() {
        DVD min = dvds.get(0);
        for (DVD d: dvds) {
            if (d.getDuration() < min.getDuration())
                min = d;
        }
        return min;
    }
    public DVD longestDVD() {
        DVD max = dvds.get(0);
        for (DVD d: dvds) {
            if (d.getDuration() > max.getDuration())
                max = d;
        }
        return max;
    }


    public static DVDCollection example1() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("If I Was a Student", 2007, 65));
        c.add(new DVD("Don't Eat Your Pencil !", 1984, 112));
        c.add(new DVD("The Exam", 2001, 180));
        c.add(new DVD("Tutorial Thoughts", 2003, 128));
        c.add(new DVD("Fried Monitors", 1999, 94));
        return c;
    }

    public static DVDCollection example2() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("Titanic",1997,194));
        c.add(new DVD("Star Wars",1977,121));
        c.add(new DVD("E.T. - The Extraterrestrial",1982,115));
        c.add(new DVD("Spider Man",2002,121));
        c.add(new DVD("Jurassic Park",1993,127));
        c.add(new DVD("Finding Nemo",2003,100));
        c.add(new DVD("The Lion King",1994,89));
        c.add(new DVD("Up",2009,96));
        c.add(new DVD("The Incredibles",2004,115));
        c.add(new DVD("Monsters Inc.",2001,92));
        c.add(new DVD("Cars",2006,117));
        c.add(new DVD("Beverly Hills Cop",1984,105));
        c.add(new DVD("Home Alone",1990,103));
        c.add(new DVD("Jaws",1975,124));
        c.add(new DVD("Men in Black",1997,98));
        c.add(new DVD("Independence Day",1996,145));
        c.add(new DVD("National Treasure: Book of Secrets",2007,124));
        c.add(new DVD("Aladdin",1992,90));
        c.add(new DVD("Twister",1996,113));
        c.add(new DVD("Iron Man",2008,126));
        c.add(new DVD("Alice in Wonderland",2010,108));
        c.add(new DVD("Transformers",2007,144));
        return c;
    }

    public static DVDCollection example3() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("Avatar",2009,162));
        c.add(new DVD("The Avengers",2012,143));
        c.add(new DVD("Titanic",1997,194));
        c.add(new DVD("The Dark Knight",2008,152));
        c.add(new DVD("Star Wars",1977,121));
        c.add(new DVD("Shrek 2",2004,93));
        c.add(new DVD("E.T. - The Extraterrestrial",1982,115));
        c.add(new DVD("Star Wars - Episode I",1999,136));
        c.add(new DVD("Pirates of the Caribbean: Dead Man's Chest",2006,151));
        c.add(new DVD("Toy Story 3",2010,103));
        c.add(new DVD("Spider Man",2002,121));
        c.add(new DVD("Transformers: Revenge of the Fallen",2009,150));
        c.add(new DVD("Star Wars - Episode III",2005,140));
        c.add(new DVD("Spider Man 2",2004,127));
        c.add(new DVD("Jurassic Park",1993,127));
        c.add(new DVD("Transformers: Dark of the Moon",2011,154));
        c.add(new DVD("Finding Nemo",2003,100));
        c.add(new DVD("Spider Man 3",2007,139));
        c.add(new DVD("Forrest Gump",1994,142));
        c.add(new DVD("The Lion King",1994,89));
        c.add(new DVD("Shrek the Third",2007,93));
        c.add(new DVD("The Sixth Sense",1999,107));
        c.add(new DVD("Up",2009,96));
        c.add(new DVD("I am Legend",2007,101));
        c.add(new DVD("Shrek",2001,90));
        c.add(new DVD("The Incredibles",2004,115));
        c.add(new DVD("Monsters Inc.",2001,92));
        c.add(new DVD("Brave",2012,100));
        c.add(new DVD("Toy Story 2",1999,92));
        c.add(new DVD("Cars",2006,117));
        c.add(new DVD("Signs",2002,106));
        c.add(new DVD("Hancock",2008,92));
        c.add(new DVD("Rush Hour 2",2001,90));
        c.add(new DVD("Meet the Fockers",2004,115));
        c.add(new DVD("The Hangover",2009,100));
        c.add(new DVD("My Big Fat Greek Wedding",2002,95));
        c.add(new DVD("Beverly Hills Cop",1984,105));
        c.add(new DVD("Mrs. Doubtfire",1993,125));
        c.add(new DVD("The Hangover Part II",2011,102));
        c.add(new DVD("The Matrix Reloaded",2003,138));
        c.add(new DVD("Home Alone",1990,103));
        c.add(new DVD("Jaws",1975,124));
        c.add(new DVD("The Blind Side",2009,129));
        c.add(new DVD("Men in Black",1997,98));
        c.add(new DVD("X-Men: The Last Stand",2006,104));
        c.add(new DVD("The Bourne Ultimatum",2007,115));
        c.add(new DVD("WALL-E",2008,98));
        c.add(new DVD("Inception",2010,148));
        c.add(new DVD("Independence Day",1996,145));
        c.add(new DVD("Pirates of the Caribbean: The Curse of the Black Pearl",2003,143));
        c.add(new DVD("The Chronicles of Narnia",2005,143));
        c.add(new DVD("War of the Worlds",2005,116));
        c.add(new DVD("National Treasure: Book of Secrets",2007,124));
        c.add(new DVD("Aladdin",1992,90));
        c.add(new DVD("How to Train Your Dragon",2010,98));
        c.add(new DVD("Shrek Forever After",2010,93));
        c.add(new DVD("Twister",1996,113));
        c.add(new DVD("Star Wars - Episode VI",1983,134));
        c.add(new DVD("Iron Man",2008,126));
        c.add(new DVD("Alice in Wonderland",2010,108));
        c.add(new DVD("Transformers",2007,144));
        c.add(new DVD("Star Wars - Episode II",2002,142));
        return c;
    }
}