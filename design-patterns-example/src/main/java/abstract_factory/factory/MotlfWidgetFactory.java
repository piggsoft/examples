package abstract_factory.factory;

import abstract_factory.ScrollBar;
import abstract_factory.WidgetFactory;
import abstract_factory.Window;
import abstract_factory.bean.MotlfScrllBar;
import abstract_factory.bean.MotlfWindow;

/**
 * Created by piggs on 2016/11/19.
 */
public class MotlfWidgetFactory extends WidgetFactory {
    public Window createWindow() {
        return new MotlfWindow();
    }

    public ScrollBar createScrollBar() {
        return new MotlfScrllBar();
    }
}
