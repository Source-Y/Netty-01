package org.example.TFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ivyevy
 * @description: 遍历文件夹
 */
public class WalkFileTreeDemo {
    public static void main(String[] args) throws IOException {
        m1();
    }

    /**
     * 遍历文件夹
     * @throws IOException
     */
    private static void m1() throws IOException {
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Path path = Paths.get("F:\\NettyDemo\\Netty-01");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("====>" + dir);
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".class")) {
                    System.out.println("class===>" + file);
                }
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });
        System.out.println(dirCount);
        System.out.println(fileCount);
    }
}
