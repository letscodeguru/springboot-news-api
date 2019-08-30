package guru.letscode.feed;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FeedMetaProperties {

	private final String META_TAG_NAME_TITLE = "title";
	private final String META_TAG_NAME_DESCRIPTION = "description";
	private final String META_TAG_NAME_NEWS_KEYWORDS = "news_keywords";
	private final String META_TAG_NAME_KEYWORDS = "keywords";

	private final String META_TAG_NAME_OG_TITLE = "og:title";
	private final String META_TAG_NAME_OG_IMAGE = "og:image";
	private final String META_TAG_NAME_OG_SITE_NAME = "og:site_name";
	private final String META_TAG_NAME_OG_DESCRIPTION = "og:description";
	private final String META_TAG_NAME_OG_TYPE = "og:type";
	private final String META_TAG_NAME_OG_URL = "og:url";
	private final String META_TAG_NAME_TWITTER_URL = "twitter:url";
	private final String META_TAG_NAME_TWITTER_TITLE = "twitter:title";
	private final String META_TAG_NAME_TWITTER_DESCRIPTION = "twitter:description";
	private final String META_TAG_NAME_TWITTER_CARD = "twitter:card";
	private final String META_TAG_NAME_TWITTER_IMAGE = "twitter:image";
	private final String META_TAG_NAME_TWITTER_CREATER = "twitter:creator";
	private final String META_TAG_NAME_TWITTER_SITE = "twitter:site";

	public static final String FEED_META_PROPERTY_TITLE = "title";
	public static final String FEED_META_PROPERTY_URL = "url";
	public static final String FEED_META_PROPERTY_KEYWORDS = "keywords";
	public static final String FEED_META_PROPERTY_IAMGE = "image";
	public static final String FEED_META_PROPERTY_DESCRIPTION = "description";
	public static final String FEED_META_PROPERTY_AUTHER = "auther";
	public static final String FEED_META_PROPERTY_CONTENT = "content";

	Map<String, String> properties = new HashMap<String, String>();

	public FeedMeta convertMetaTagsToMetaProperties(FeedMetaTags metaTags) {
		Map<String, String> metaTagsName = metaTags.getMetaTagNames();

		FeedMeta meta = new FeedMeta();
		meta.setTitle(metaTagsName.containsKey(META_TAG_NAME_TITLE) ? metaTagsName.get(META_TAG_NAME_TITLE)
				: metaTagsName.containsKey(META_TAG_NAME_OG_TITLE) ? metaTagsName.get(META_TAG_NAME_OG_TITLE)
						: metaTagsName.get(META_TAG_NAME_TWITTER_TITLE));
		meta.setDescription(
				metaTagsName.containsKey(META_TAG_NAME_DESCRIPTION) ? metaTagsName.get(META_TAG_NAME_DESCRIPTION)
						: metaTagsName.containsKey(META_TAG_NAME_OG_DESCRIPTION)
								? metaTagsName.get(META_TAG_NAME_OG_DESCRIPTION)
								: metaTagsName.get(META_TAG_NAME_TWITTER_DESCRIPTION));
		meta.setUrl(metaTagsName.containsKey(META_TAG_NAME_OG_URL) ? metaTagsName.get(META_TAG_NAME_OG_URL)
				: metaTagsName.containsKey(META_TAG_NAME_TWITTER_URL) ? metaTagsName.get(META_TAG_NAME_TWITTER_URL)
						: null);
		meta.setImage(metaTagsName.containsKey(META_TAG_NAME_OG_IMAGE) ? metaTagsName.get(META_TAG_NAME_OG_IMAGE)
				: metaTagsName.containsKey(META_TAG_NAME_TWITTER_IMAGE) ? metaTagsName.get(META_TAG_NAME_TWITTER_IMAGE)
						: null);
		return meta;
	};

	@Override
	public String toString() {
		return "FeedMetaProperties [properties=" + properties + "]";
	}
}
