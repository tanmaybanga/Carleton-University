public class DVD implements Comparable {
    private   String title;
    private   int year;
    private   int duration;

    public DVD () { this ("",0,0); }
    public DVD (String newTitle, int y, int minutes) {
        title = newTitle;
        year = y;
        duration = minutes;
    }

    public int compareTo(Object obj) {
        if (obj instanceof DVD) {
            DVD aDVD = (DVD)obj;
            return title.compareTo(aDVD.title);
        }
        return 0;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public int getYear() { return year; }
    public void setTitle(String t) { title = t; }
    public void setDuration(int d) { duration = d; }
    public void setYear(int y) { year = y; }

    public String toString() {
        return ("DVD (" + year + "): \"" + title + "\" with length: " + duration + " minutes");
    }
}