package abstract_factory.factory;

import abstract_factory.ScrollBar;
import abstract_factory.WidgetFactory;
import abstract_factory.Window;
import abstract_factory.bean.PMScrollBar;
import abstract_factory.bean.PMWindow;

/**
 * Created by piggs on 2016/11/19.
 */
public class PMWidgetFactory extends WidgetFactory {
    public Window createWindow() {
        return new PMWindow();
    }

    public ScrollBar createScrollBar() {
        return new PMScrollBar();
    }
}
