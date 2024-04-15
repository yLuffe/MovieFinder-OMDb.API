package Model;

import java.util.Arrays;

public class Movie {

    private String title; //
    private String year; //
    private String genre; //
    private String director; //
    private String writer; //
    private String[] actors; //
    private String plot; //
    private String language;
    private String country;
    private String posterLink; //
    private String imdbID;
    private String type; //
    private String parentalGuidance; //
    private String runtime; //

    // Constructors
    public Movie() {
    }
    
    public Movie(String title, String year, String imdbID){
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
    }

    public Movie(String title, String year, String genre, String director, String writer,
            String[] actors, String plot, String language, String country, String posterLink,
            String imdbID, String type, String parentalGuidance, String runtime) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.posterLink = posterLink;
        this.imdbID = imdbID;
        this.type = type;
        this.parentalGuidance = parentalGuidance;
        this.runtime = runtime;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setParentalGuidance(String parentalGuidance) {
        this.parentalGuidance = parentalGuidance;
    }
    
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String[] getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getParentalGuidance() {
        return parentalGuidance;
    }

    public String getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return "Filme: " + title + "\nAno: " + year
                + "\nGênero: " + genre
                + "\nDiretor: " + director
                + "\nEscritor: " + writer
                + "\nAtores: " + Arrays.toString(actors)
                + "\nEnredo: " + plot
                + "\nIdioma: " + language
                + "\nPaís: " + country
                + "\nLink do Pôster: " + posterLink
                + "\nImdb ID: " + imdbID;
    }

}
