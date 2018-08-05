package data;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@RequestScoped
public class FileUploadProcessor {

    private static final String SETTINGS_FILE = "settings.properties";

    private DataProvider dataProvider;

    @Inject
    public FileUploadProcessor(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Inject
    private SingleWordDao singleWordDao;

    public FileUploadProcessor() {
    }

    public String getUploadFilePath() throws IOException {
        return System.getProperty("user.dir");
    }

    public File uploadFile(Part filePart, String userName) throws FileNotFound, IOException {
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            throw new FileNotFound("No file has been uploaded");
        }

        File file = new File(getUploadFilePath() + "/" + fileName);
        Files.deleteIfExists(file.toPath());
        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());
        List<SingleWord> newList = dataProvider.getListOfWords(file.toPath().toString());
        for (SingleWord s : newList) {
            s.setUserName(userName);
            singleWordDao.save(s);
        }

        fileContent.close();

        return  file;

    }
}
