package persistence;

import persistence.models.PhoneModel;

import java.util.List;

public interface IPhoneSearch {

    List<PhoneModel> performSearch(final String searchWord, final Sites sites);

    List<PhoneModel> performSearch(final List<Sites> sites, final String searchWord);

}
