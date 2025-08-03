import java.util.*;
import java.util.concurrent.*;
import java.time.*;
import java.util.Arrays;

public class FutureEx {
    public static void main (String[] args) {

        RemoteService service = new RemoteService();
        service.getUserRecentActs(activities -> {
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        });

    }
}

class RemoteService {

    void getUserRecentActs(ResultCallback result) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> {
            Future<List<Like>> like = executor.submit(getUserLikes());
            Future<List<Comment>> comment = executor.submit(getUserComments());
            Future<List<Post>> post = executor.submit(getUserPosts());
            Future<List<Share>> share = executor.submit(getUserShares());

            List<Activity> activities = new ArrayList<>();
            try {
                activities.addAll(like.get());
                activities.addAll(comment.get());
                activities.addAll(post.get());
                activities.addAll(share.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            activities.sort(Comparator.comparing(Activity::getDate));

            result.onSuccess(activities);

        });

        try {
            Thread.sleep(2000);
            executor.shutdown();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

    Callable<List<Like>> getUserLikes() {
        return () -> Arrays.asList(new Like(LocalDateTime.now().minusDays(1)),
                             new Like(LocalDateTime.now().minusDays(2)),
                             new Like(LocalDateTime.now().minusDays(3)));
    }

    Callable<List<Comment>> getUserComments() {
        return () -> Arrays.asList(new Comment(LocalDateTime.now().minusDays(1)),
                             new Comment(LocalDateTime.now().minusDays(2)),
                             new Comment(LocalDateTime.now().minusDays(3)));
    }

    Callable<List<Post>> getUserPosts() {
        return () -> Arrays.asList(new Post(LocalDateTime.now().minusDays(1)),
                             new Post(LocalDateTime.now().minusDays(2)),
                             new Post(LocalDateTime.now().minusDays(3)));
    }

    Callable<List<Share>> getUserShares() {
        return () -> Arrays.asList(new Share(LocalDateTime.now().minusDays(1)),
                             new Share(LocalDateTime.now().minusDays(2)),
                             new Share(LocalDateTime.now().minusDays(3)));
    }
    
}

interface Activity {
    LocalDateTime getDate();
}

interface ResultCallback {
    void onSuccess(List<Activity> activities);
}

class Like implements Activity {
    LocalDateTime date;

    Like (LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Like{" +
                "date=" + date +
                '}';
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }
}

class Comment implements Activity {
    LocalDateTime date;

    Comment (LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "date=" + date +
                '}';
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }
}

class Post implements Activity {
    LocalDateTime date;

    Post (LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "date=" + date +
                '}';
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }
}

class Share implements Activity {
    LocalDateTime date;

    Share (LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Share{" +
                "date=" + date +
                '}';
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }
}

