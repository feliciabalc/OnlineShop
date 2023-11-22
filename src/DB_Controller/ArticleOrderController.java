package DB_Controller;

import DB_Repo.ArticleOrderRepoDB;
import DB_Repo.ArticleRepoDB;
import DB_Repo.OrderRepoDB;
import Entities.Articles;
import Entities.Order;

import java.util.ArrayList;
import java.util.List;

public class ArticleOrderController {
    private ArticleOrderRepoDB articleOrderRepo;
    private ArticleRepoDB articleRepo;
    private OrderRepoDB orderRepo;

    public ArticleOrderController(ArticleOrderRepoDB articleOrderRepo, ArticleRepoDB articleRepo, OrderRepoDB orderRepo) {
        this.articleOrderRepo = articleOrderRepo;
        this.articleRepo = articleRepo;
        this.orderRepo = orderRepo;
    }

    public void saveIntoArticleOrder(List<Integer> articleIds, int orderId) {
        articleOrderRepo.saveIntoArticleOrder(articleIds,orderId);
    }

    public Order  getOrder(int OrderId){
        Order order = orderRepo.findById(OrderId);
        return order;
    }

    public Articles getArticle(int ArticleId){
        Articles article = articleRepo.findById(ArticleId);
        return article;
    }

    public List<Articles> loadArticleIdsByOrderId(int orderId){
        List<Integer> articles = articleOrderRepo.loadArticleIdsByOrderId(orderId);
        List<Articles> articlesList = new ArrayList<>();
        for(int i=0; i<articles.size();i++){
            Articles article = articleRepo.findById(articles.get(i));
            articlesList.add(article);
        }
        return articlesList;
    }
}
