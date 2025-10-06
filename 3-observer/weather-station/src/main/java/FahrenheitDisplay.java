public class FahrenheitDisplay implements Observer, DisplayElement{
    float fahrenTemp;
    WeatherData weatherData;
    public FahrenheitDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
    }

    public void update(float temp, float humidity, float pressure){
        fahrenTemp = temp * 9;
        fahrenTemp = fahrenTemp / 5;
        fahrenTemp = fahrenTemp + 32; 
        display();
    }

    public void display(){
        System.out.println("La temperatura se ha actualizado, en fahrenheit es: " + fahrenTemp);
    }
}
