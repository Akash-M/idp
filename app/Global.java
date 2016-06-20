import configs.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;


/**
 * Created by saeed on 9/March/15 AD.
 */
public class Global extends GlobalSettings {

    protected ApplicationContext applicationContext;

    @Override
    public void onStart(Application app) {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public final <A> A getControllerInstance(Class<A> clazz) {
        return applicationContext.getBean(clazz);
    }

    // For CORS
    private class ActionWrapper extends Action.Simple {
        public ActionWrapper(Action<?> action) {
            this.delegate = action;
        }

        @Override
        public F.Promise<Result> call(Http.Context ctx) throws java.lang.Throwable {
            F.Promise<Result> result = this.delegate.call(ctx);
            Http.Response response = ctx.response();
            response.setHeader("Access-Control-Allow-Origin", "*");
            return result;
        }
    }

    @Override
    public Action<?> onRequest(Http.Request request,
                               java.lang.reflect.Method actionMethod) {
        return new ActionWrapper(super.onRequest(request, actionMethod));
    }

}
