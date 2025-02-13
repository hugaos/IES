import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class IpmaApiClient {

    private IpmaService service;

    public IpmaApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(IpmaService.class);
    }

    public IpmaCityForecast getForecast(int cityId) throws IOException {
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityId);
        Response<IpmaCityForecast> apiResponse = callSync.execute();
        return apiResponse.body();
    }
}