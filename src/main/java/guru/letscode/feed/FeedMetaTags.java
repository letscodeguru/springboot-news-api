package guru.letscode.feed;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FeedMetaTags {

	private final String META_TAG_ATTR_NAME = "name";
	private final String META_TAG_ATTR_CONTENT = "content";
	private final String META_TAG_ATTR_PROPERTY = "property";

	private Map<String, String> metaTagNames = new HashMap<String, String>();

	public FeedMetaTags(final Elements metaElements) {
		
		for (Element element : metaElements) {
			if (element.hasAttr(META_TAG_ATTR_NAME)) {
				metaTagNames.put(element.attr(META_TAG_ATTR_NAME), element.attr(META_TAG_ATTR_CONTENT));
			} else if (element.hasAttr(META_TAG_ATTR_PROPERTY)) {
				metaTagNames.put(element.attr(META_TAG_ATTR_PROPERTY), element.attr(META_TAG_ATTR_CONTENT));
			}
		}
	}

	public Map<String, String> getMetaTagNames() {
		return metaTagNames;
	}
}
