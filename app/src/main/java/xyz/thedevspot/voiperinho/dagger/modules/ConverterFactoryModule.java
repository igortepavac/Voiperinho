package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import retrofit.Converter;
import retrofit.GsonConverterFactory;

/**
 * Created by foi on 14/02/16.
 */

@Module
public class ConverterFactoryModule {

    @Provides
    public Converter.Factory providesConverterFactory() {
        return GsonConverterFactory.create();
    }
}
