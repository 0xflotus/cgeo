package cgeo.geocaching.filter;

import cgeo.geocaching.Geocache;
import cgeo.geocaching.enumerations.CacheSize;

import java.util.ArrayList;

class SizeFilter extends AbstractFilter {
    private final CacheSize cacheSize;

    public SizeFilter(CacheSize cacheSize) {
        super(cacheSize.id);
        this.cacheSize = cacheSize;
    }

    @Override
    public boolean accepts(Geocache cache) {
        return cacheSize == cache.getSize();
    }

    @Override
    public String getName() {
        return cacheSize.getL10n();
    }

    public static class Factory implements IFilterFactory {

        @Override
        public IFilter[] getFilters() {
            final CacheSize[] cacheSizes = CacheSize.values();
            final ArrayList<SizeFilter> filters = new ArrayList<SizeFilter>();
            for (CacheSize cacheSize : cacheSizes) {
                if (cacheSize != CacheSize.UNKNOWN) {
                    filters.add(new SizeFilter(cacheSize));
                }
            }
            return filters.toArray(new SizeFilter[filters.size()]);
        }

    }
}
