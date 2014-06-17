package tzhmufl2.android_hellospring.network;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import tzhmufl2.android_hellospring.domain.DTOCharacterResponseList;

/**
 * Created by tzhmufl2 on 15.06.14.
 */
public class AsyncServerCall extends AsyncTask<String, Void, DTOCharacterResponseList>
{
    private String url;
    private HTTPCallback callback;

    public AsyncServerCall(String url,HTTPCallback callback) {
        this.url = url;
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(DTOCharacterResponseList result) {
        super.onPostExecute(result);
        callback.postExecute(result);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        callback.preExecute();
    }

    @Override
    protected DTOCharacterResponseList doInBackground(String... params) {
        try
        {
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<DTOCharacterResponseList> characters  =  restTemplate.exchange(url, HttpMethod.GET, request, DTOCharacterResponseList.class);

            return characters.getBody();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
