package JavaBasics3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author aidan.mattson
 * Java Basics 3
 * Assignment 1: List all files and directories in a given directory
 */
public class Assignment1 {

    /**
     * Recursive function to search a directory and find all files
     * @param path path to search in
     * @param depth how many layers into the directory we are
     * @return a list of all files found
     */
    public List<String> findFiles(String path, int depth) {
        List<String> files = new ArrayList<>();
        File target = new File(path);

        // attempt to read directory
        if (target.isDirectory()) {
            // add directory to file list
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < depth; i++)
                newString.append("| ");
            newString.append(target.getName());
            files.add(newString.toString());

            // walk directory for new files - max depth 1 so we can format easier
            try(Stream<Path> paths = Files.walk(Paths.get(path), 1)) {
                List<Path> result = paths.collect(Collectors.toList());
                for (Path p : result.subList(1, result.size())) {
                    // recursively traverse new files
                    files.addAll(findFiles(p.toString(), depth + 1));
                }
            } catch (IOException e) {
                System.out.println("Error reading path '" + path + "'");
            }
        }

        //attempt to read file
        else if (target.isFile()) {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < depth; i++)
                newString.append("| ");
            newString.append(target.getName());
            files.add(newString.toString());
        }

        // for each file in the directory, add or recurse
        return files;
    }

    /**
     * create and start the program; get path
     * @param args if user specifies a path, use it
     */
    public static void main(String[] args) {
        final String path;

        // case - too many args
        if (args.length > 1) {
            System.out.println("Too many parameters. Exiting...");
            return;
        }

        // case - commandline path specified
        if (args.length == 1) {
            System.out.println("Argument found - running search with path '" + args[0] + "'");
            path = args[0];
        }

        // case - accept path input from user
        else {
            System.out.print("No path specified; please enter a path: \n - ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine();
        }

        // call the function with the path specified
        Assignment1 fileFinder = new Assignment1();
        List<String> files = fileFinder.findFiles(path, 0);

        // print results
        System.out.println("");
        for (String entry : files)
            System.out.println(entry);
    }
}
