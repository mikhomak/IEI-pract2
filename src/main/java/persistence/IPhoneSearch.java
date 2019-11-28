package persistence;

import persistence.models.PhoneModel;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IPhoneSearch {

    List<PhoneModel> performSearch(final String searchWord, final Sites sites) throws UnsupportedEncodingException;

    List<PhoneModel> performSearch( final String searchWord, final List<Sites> sites);

}
