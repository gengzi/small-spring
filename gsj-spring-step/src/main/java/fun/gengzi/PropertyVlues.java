package fun.gengzi;

import java.util.ArrayList;
import java.util.List;

public class PropertyVlues {

    private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();


    public void addPropertyVlaue(String key, Object value) {
        PropertyValue propertyValue = new PropertyValue(key, value);
        propertyValues.add(propertyValue);
    }


    public PropertyValue[] getPropertyValue() {
        return  propertyValues.toArray(new PropertyValue[0]);
    }


    public Object getPropertyValue(String key) {
        for (PropertyValue propertyValue : propertyValues) {
            if (key.equals(propertyValue.getKey())) {
                return propertyValue.getValue();
            }
        }
        return null;
    }

}
