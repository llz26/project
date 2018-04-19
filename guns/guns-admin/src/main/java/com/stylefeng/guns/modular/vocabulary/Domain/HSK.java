package com.stylefeng.guns.modular.vocabulary.Domain;


import javax.persistence.*;

@Entity
@Table(name="sys_hsk")
public class HSK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="level")
    private int level;
    @Column(name="word")
    private String word;
    @Column(name="pronunciation")
    private String pronunciation;
    @Column(name="definition")
    private String definition;
    @Column(name="mp3")
    private String mp3;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word  = word ;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }


}
