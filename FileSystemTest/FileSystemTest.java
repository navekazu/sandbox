import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileSystemTest {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        FileSystem fileSystem = path.getFileSystem();

        fileSystem.getFileStores()
            .forEach(
                fileStore -> detail(fileSystem, fileStore)
            );
    }

    private static void detail(FileSystem fileSystem, FileStore fileStore) {
        try {
            System.out.println("----------------------------------------");

            // fileStore
            System.out.println(String.format("name:%s type:%s total space:%,dGB", fileStore.name(), fileStore.type(), fileStore.getTotalSpace()/1024/1024/1024));

            // fileSystemViews
            System.out.print("fileSystemViews:");
            fileSystem.supportedFileAttributeViews().iterator().forEachRemaining(
                fileSystemViews -> System.out.print(fileSystemViews+" ")
            );
            System.out.println();

            ////////////////////////////////////////
            // FileStoreAttributeView

            // AclFileAttributeView
            System.out.println("AclFileAttributeView:"+fileStore.supportsFileAttributeView(AclFileAttributeView.class));
            if (fileStore.supportsFileAttributeView(AclFileAttributeView.class)) {
                AclFileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), AclFileAttributeView.class);
                view.getAcl().stream().forEach(aclEntry -> System.out.print(aclEntry.toString()));
            }

            // BasicFileAttributeView
            System.out.println("BasicFileAttributeView:"+fileStore.supportsFileAttributeView(BasicFileAttributeView.class));
            if (fileStore.supportsFileAttributeView(BasicFileAttributeView.class)) {
                BasicFileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), BasicFileAttributeView.class);
                System.out.println(view.readAttributes().lastAccessTime().toString());
            }

            // DosFileAttributeView
            System.out.println("DosFileAttributeView:"+fileStore.supportsFileAttributeView(DosFileAttributeView.class));
            if (fileStore.supportsFileAttributeView(DosFileAttributeView.class)) {
                DosFileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), DosFileAttributeView.class);
            }

            // FileAttributeView
            System.out.println("FileAttributeView:"+fileStore.supportsFileAttributeView(FileAttributeView.class));
            if (fileStore.supportsFileAttributeView(FileAttributeView.class)) {
                FileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), FileAttributeView.class);
            }

            // FileOwnerAttributeView

            // FileStoreAttributeView

            // PosixFileAttributeView
            System.out.println("PosixFileAttributeView:"+fileStore.supportsFileAttributeView(PosixFileAttributeView.class));
            if (fileStore.supportsFileAttributeView(PosixFileAttributeView.class)) {
                PosixFileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), PosixFileAttributeView.class);
            }

            // UserDefinedFileAttributeView
            System.out.println("UserDefinedFileAttributeView:"+fileStore.supportsFileAttributeView(UserDefinedFileAttributeView.class));
            if (fileStore.supportsFileAttributeView(UserDefinedFileAttributeView.class)) {
                UserDefinedFileAttributeView view = Files.getFileAttributeView(fileSystem.getRootDirectories().iterator().next(), UserDefinedFileAttributeView.class);
                view.list().stream().forEach(v -> System.out.print(v+" "));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
