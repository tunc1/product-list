package app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class Product
{
    @Id
    private String id;
    private String name;
    @DBRef
    private Category category;
    private Map<String,String> properties;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public Category getCategory()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category=category;
    }
    public Map<String,String> getProperties()
    {
        return properties;
    }
    public void setProperties(Map<String,String> properties)
    {
        this.properties=properties;
    }
}