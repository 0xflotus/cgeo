package cgeo.geocaching.filter;

import cgeo.geocaching.Geocache;
import cgeo.geocaching.R;

import org.eclipse.jdt.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

class DifficultyFilter extends AbstractRangeFilter {

    private static final long serialVersionUID = -5154908510447657327L;

    public DifficultyFilter(final int difficulty) {
        super(R.string.cache_difficulty, difficulty);
    }

    @Override
    public boolean accepts(@NonNull final Geocache cache) {
        final float difficulty = cache.getDifficulty();
        return rangeMin <= difficulty && difficulty < rangeMax;
    }

    public static class Factory implements IFilterFactory {

        private static final long serialVersionUID = -3207858180443543737L;
        private static final int DIFFICULTY_MIN = 1;
        private static final int DIFFICULTY_MAX = 5;

        @Override
        @NonNull
        public List<IFilter> getFilters() {
            final List<IFilter> filters = new ArrayList<>(DIFFICULTY_MAX);
            for (int difficulty = DIFFICULTY_MIN; difficulty <= DIFFICULTY_MAX; difficulty++) {
                filters.add(new DifficultyFilter(difficulty));
            }
            return filters;
        }

    }
}
