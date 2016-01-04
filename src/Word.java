/**
 * Created by lisa on 15-12-28.
 */
public class Word
{
    String word;
    String meaning;
    String example;

    public Word(String w,String m,String e)
    {
        word = w;
        meaning = m;
        example = e;
    }

    //getters
    public String getWord()
    {
        return word;
    }
    public String getMeaning()
    {
        return meaning;
    }
    public String getExample(){
        return example;
    }

    //setters

    public void setWord(String word){
        this.word = word;
    }
    public void setMeaning(String meaning){
        this.meaning = meaning;
    }
    public void setExample(String example){
        this.example = example;
    }
}
