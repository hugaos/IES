import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.io.IOException;

public class AnyCityForecast {

    private static final Logger logger = Logger.getLogger(AnyCityForecast.class.getName());
    private static final int[] CITY_IDS = {1010500, 1020300, 1030300, 1070500, 1050200, 1182300, 1151200, 1110600};
    private static final Random random = new Random();
    private static final int INTERVAL = 20000; // 20 segundos

    public static void main(String[] args) {
        IpmaApiClient client = new IpmaApiClient();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int cityId = CITY_IDS[random.nextInt(CITY_IDS.length)];
                try {
                    IpmaCityForecast forecast = client.getForecast(cityId);
                    if (forecast != null) {
                        var firstDay = forecast.getData().listIterator().next();
                        logger.info(String.format("City ID: %d | Date: %s | Max Temp: %s°C",
                                cityId, firstDay.getForecastDate(), firstDay.getTMax()));
                    } else {
                        logger.warning("No forecast data available.");
                    }
                } catch (IOException e) {
                    logger.severe("Failed to fetch forecast: " + e.getMessage());
                }
            }
        }, 0, INTERVAL);
    }
}
