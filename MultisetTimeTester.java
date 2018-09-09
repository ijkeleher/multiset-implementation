import java.io.*;
import java.util.*;


/**
 * Framework to test the multiset implementations.
 *
 * @author jkcchan
 */
public class MultisetTimeTester
{
	/** Name of class, used in error messages. */
	protected static final String progName = "MultisetTimeTester";

	/** Standard outstream. */
	protected static final PrintStream outStream = System.out;

	/**
	 * Print help/usage message.
	 */
	public static void usage(String progName) {
		System.err.println(progName + ": <implementation> [fileName to output search results to]");
		System.err.println("<implementation> = <linkedlist | sortedlinkedlist | bst| hash | baltree>");
		System.exit(1);
	} // end of usage


	/**
	 * Process the operation commands coming from inReader, and updates the multiset according to the operations.
	 *
	 * @param inReader Input reader where the operation commands are coming from.
	 * @param searchOutWriter Where to output the results of search.
	 * @param multiset The multiset which the operations are executed on.
	 *
	 * @throws IOException If there is an exception to do with I/O.
	 */
	public static void processOperations(BufferedReader inReader, PrintWriter searchOutWriter, Multiset<String> multiset)
		throws IOException
	{
		String line;
		int lineNum = 1;
		boolean bQuit = false;

		// continue reading in commands until we either receive the quit signal or there are no more input commands
		while (!bQuit && (line = inReader.readLine()) != null) {
			String[] tokens = line.split(" ");

			// check if there is at least an operation command
			if (tokens.length < 1) {
				System.err.println(lineNum + ": not enough tokens.");
				lineNum++;
				continue;
			}

			String command = tokens[0];
			// determine which operation to execute
			switch (command.toUpperCase()) {
				// add
				case "A":
					if (tokens.length == 2) {
						long startTime = System.nanoTime();
						multiset.add(tokens[1]);
						long endTime = System.nanoTime();
						double estimatedTime = ((double)(endTime - startTime)) / Math.pow(10, 9);
						System.out.println("time taken = " + estimatedTime + " sec");
					}
					else {
						System.err.println(lineNum + ": not enough tokens.");
					}
					break;
				// search
				case "S":
					if (tokens.length == 2) {
						long startTime = System.nanoTime();
						int foundNumber = multiset.search(tokens[1]);
						long endTime = System.nanoTime();
						double estimatedTime = ((double)(endTime - startTime)) / Math.pow(10, 9);
						searchOutWriter.println(tokens[1] + " " + foundNumber);
						System.out.println("time taken = " + estimatedTime + " sec");

					}
					else {
						// we print -1 to indicate error for automated testing
						searchOutWriter.println(-1);
						System.err.println(lineNum + ": not enough tokens.");
					}
					break;
				// remove one instance
				case "RO":
					if (tokens.length == 2) {
						long startTime = System.nanoTime();
						multiset.removeOne(tokens[1]);
						long endTime = System.nanoTime();
						double estimatedTime = ((double)(endTime - startTime)) / Math.pow(10, 9);
						System.out.println("time taken = " + estimatedTime + " sec");
					}
					else {
						System.err.println(lineNum + ": not enough tokens.");
					}
					break;
				// remove all instances
				case "RA":
					if (tokens.length == 2) {
						long startTime = System.nanoTime();
						multiset.removeAll(tokens[1]);
						long endTime = System.nanoTime();
						double estimatedTime = ((double)(endTime - startTime)) / Math.pow(10, 9);
						System.out.println("time taken = " + estimatedTime + " sec");
					}
					else {
						System.err.println(lineNum + ": not enough tokens.");
					}
					break;
				// print
				case "P":
					multiset.print(outStream);
					break;
				// quit
				case "Q":
					bQuit = true;
					break;
				default:
					System.err.println(lineNum + ": Unknown command.");
			}

			lineNum++;
		}

	} // end of processOperations()


	/**
	 * Process the operation commands coming from file which is the fixed set.
	 *
	 * @param inReader Input reader where the operation commands are coming from.
	 * @param multiset The multiset which the operations are executed on.
	 *
	 * @throws IOException If there is an exception to do with I/O.
	 */
	public static void dataLoader(BufferedReader inReader,Multiset<String> multiset)
		throws IOException
	{
		String line;

		while ((line = inReader.readLine()) != null) {

						multiset.add(line);

	}
	multiset.print(outStream);
}


	/**
	 * Main method.  Determines which implementation to test.
	 */
	public static void main(String[] args) {

		// check number of command line arguments
		if (args.length > 2 || args.length < 1) {
			System.err.println("Incorrect number of arguments.");
			usage(progName);
		}

		String implementationType = args[0];

		String searchOutFilename = null;
		if (args.length == 2) {
			searchOutFilename = args[1];
		}


		// determine which implementation to test
		Multiset<String> multiset = null;
		switch(implementationType) {
			case "linkedlist":
				multiset = new LinkedListMultiset<String>();
				break;
			case "sortedlinkedlist":
				multiset = new SortedLinkedListMultiset<String>();
				break;
			case "bst":
				multiset = new BstMultiset<String>();
				break;
			case "hash":
				multiset = new HashMultiset<String>();
				break;
			case "baltree":
				multiset = new BalTreeMultiset<String>();
				break;
			default:
				System.err.println("Unknown implmementation type.");
				usage(progName);
		}


		// construct in and output streams/writers/readers, then process each operation.
		try {
			// load dataset
			BufferedReader data = new BufferedReader(new FileReader("dataset.in"));
			dataLoader(data, multiset);
			// process operations through args with commands
			BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter searchOutWriter = new PrintWriter(System.out, true);

			if (searchOutFilename != null) {
				searchOutWriter = new PrintWriter(new FileWriter(searchOutFilename), true);
			}
			// process the operations
			processOperations(inReader, searchOutWriter, multiset);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	} // end of main()

} // end of class MultisetTester
