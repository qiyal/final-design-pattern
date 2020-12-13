package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.databases.BookDatabase;
import sample.models.products.Book;
import sample.models.products.BookGenreEnum;
import sample.services.AuthService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private static HomeController instance = new HomeController();
    private BookDatabase bookDatabase = BookDatabase.getInstance();
    private int pageNumber = 1;

    private AuthService service = AuthService.getInstance();

    private ArrayList<AnchorPane> anchorPanes = new ArrayList<>();

    private ArrayList<ImageView> imageViews = new ArrayList<>();

    private ArrayList<Label> labelsName = new ArrayList<>();
    private ArrayList<Label> labelsAuthorName = new ArrayList<>();
    private ArrayList<Label> labelsGenre = new ArrayList<>();
    private ArrayList<Label> labelsPrice = new ArrayList<>();


    @FXML
    private GridPane grid;

    // AnchorPane
    @FXML
    private AnchorPane child1;

    @FXML
    private AnchorPane child2;

    @FXML
    private AnchorPane child3;

    @FXML
    private AnchorPane child4;

    @FXML
    private AnchorPane child5;

    @FXML
    private AnchorPane child6;

    // Images
    @FXML
    private ImageView bookImage1;

    @FXML
    private ImageView bookImage2;

    @FXML
    private ImageView bookImage3;

    @FXML
    private ImageView bookImage4;

    @FXML
    private ImageView bookImage5;

    @FXML
    private ImageView bookImage6;


    // Names
    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label name3;

    @FXML
    private Label name4;

    @FXML
    private Label name5;

    @FXML
    private Label name6;



    //Author Names
    @FXML
    private Label authorName1;

    @FXML
    private Label authorName2;

    @FXML
    private Label authorName3;

    @FXML
    private Label authorName4;

    @FXML
    private Label authorName5;

    @FXML
    private Label authorName6;

    // Genres
    @FXML
    private Label genre1;

    @FXML
    private Label genre2;

    @FXML
    private Label genre3;

    @FXML
    private Label genre4;

    @FXML
    private Label genre5;

    @FXML
    private Label genre6;

    //Prices
    @FXML
    private Label price1;
    @FXML
    private Label price2;
    @FXML
    private Label price3;
    @FXML
    private Label price4;
    @FXML
    private Label price5;
    @FXML
    private Label price6;

    // Add to like
    @FXML
    private Button AddToLike1;

    @FXML
    private Button AddToLike2;

    @FXML
    private Button AddToLike3;

    @FXML
    private Button AddToLike4;

    @FXML
    private Button AddToLike5;

    @FXML
    private Button AddToLike6;

    // Add to cart
    @FXML
    private Button addToCard1;

    @FXML
    private Button addToCard2;

    @FXML
    private Button addToCard3;

    @FXML
    private Button addToCard4;

    @FXML
    private Button addToCard5;

    @FXML
    private Button addToCard6;


    // Btns
    @FXML
    private Button prevBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button bookBtn;

    @FXML
    private Button comicsBtn;

    @FXML
    private Button profileBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button cartBtn;

    @FXML
    private Button nextBtn;

    @FXML
    void initialize() {
        loginBtn.setOnAction(event -> {
            openWindow(loginBtn, "Login", false, "/sample/views/login.fxml");
        });

        signUpBtn.setOnAction(event -> {
            openWindow(signUpBtn, "Sign Up", false, "/sample/views/sign-up.fxml");
        });

        initAllElementArrayList();
    }

    private void openWindow(Node note, String title, boolean hide, String path) {
        if (hide) {
            note.getScene().getWindow().hide();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void initAllElementArrayList() {
        nextBtn.setOnAction(event -> {
            next();
        });

        prevBtn.setOnAction(event -> {
            prev();
        });

        anchorPanes.add(child1);
        anchorPanes.add(child2);
        anchorPanes.add(child3);
        anchorPanes.add(child4);
        anchorPanes.add(child5);
        anchorPanes.add(child6);

        imageViews.add(bookImage1);
        imageViews.add(bookImage2);
        imageViews.add(bookImage3);
        imageViews.add(bookImage4);
        imageViews.add(bookImage5);
        imageViews.add(bookImage6);

        labelsName.add(name1);
        labelsName.add(name2);
        labelsName.add(name3);
        labelsName.add(name4);
        labelsName.add(name5);
        labelsName.add(name6);

        labelsAuthorName.add(authorName1);
        labelsAuthorName.add(authorName2);
        labelsAuthorName.add(authorName3);
        labelsAuthorName.add(authorName4);
        labelsAuthorName.add(authorName5);
        labelsAuthorName.add(authorName6);

        labelsGenre.add(genre1);
        labelsGenre.add(genre2);
        labelsGenre.add(genre3);
        labelsGenre.add(genre4);
        labelsGenre.add(genre5);
        labelsGenre.add(genre6);

        labelsPrice.add(price1);
        labelsPrice.add(price2);
        labelsPrice.add(price3);
        labelsPrice.add(price4);
        labelsPrice.add(price5);
        labelsPrice.add(price6);

        setInfos();
    }

    public static HomeController getInstance() {
        return instance;
    }

    public Button getPrevBtn() {
        return prevBtn;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public void setInfos() {
        ArrayList<Book> books = bookDatabase.getBooksByOnly(pageNumber);

        for (Book book : books) {
            System.out.println(book.getName());
        }

        for (int i = 0; i < 6; i++) {
            if (i < books.size()) {
                anchorPanes.get(i).setVisible(true);
                imageViews.get(i).setImage(getNewImage(books.get(i).getUrlImage()));
                labelsName.get(i).setText(getNameFormat(books.get(i).getName()));
                labelsAuthorName.get(i).setText(getFormatAuthorNames(new ArrayList<>(books.get(i).getAuthorName())));
                labelsGenre.get(i).setText(getFormatGenre(books.get(i).getGenre()));
                labelsPrice.get(i).setText(priceToString(books.get(i).getPrice()));
            }
            else {
                anchorPanes.get(i).setVisible(false);
            }
        }


    }

    public void prev() {
        if(pageNumber != 1) {
            pageNumber--;
            setInfos();
        }
    }

    public void next() {
        if(pageNumber * 6 < bookDatabase.size()) {
            pageNumber++;
            setInfos();
        }
    }

    public Image getNewImage(String url) {
        return new Image(String.valueOf("/sample/assets/image/" + url));
    }

    public String getNameFormat(String name) {
        if (name.length() > 15) {
            name = name.substring(0, 15) + "...";
        }
        return name;
    }

    public String getFormatAuthorNames(List<String> names) {
        String result = "";

        for (int i = 0; i < names.size(); i++) {
            if (result.length() > 15) {
                result = result.substring(0, 15) + "...";
                break;
            }

            result += names.get(i);

            if (i < names.size() - 1) {
                result += ",";
            }
        }
        return result;
    }

    public String getFormatGenre(BookGenreEnum bookGenreEnum) {
        return bookGenreEnum.toString().toLowerCase();
    }

    public String priceToString(int price) {
        return Integer.toString(price);
    }

}
