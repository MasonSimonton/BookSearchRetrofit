package viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import models.VolumesResponse;
import repositories.BookRepository;

import io.github.cdimascio.dotenv.Dotenv;


public class BookSearchViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel(@NonNull Application application){
        super();
    }

    public void init(){
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }


    public void searchVolumes(String keyword, String author){
        Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();

        // Calls repository to search
        bookRepository.searchVolumes(keyword, author, dotenv.get("GOOGLE_API_KEY"));
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData(){
        return volumesResponseLiveData;
    }
}
