package upwork.job.rest.api.facade.converter;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface DefaultPopulator<SOURCE, TARGET> {

    void populate(final SOURCE source, final TARGET target);

    SOURCE convert(final TARGET source);
}