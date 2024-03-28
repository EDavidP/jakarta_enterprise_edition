package book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;

import artifact.MyServiceSOAP;
import artifact.MyServiceSOAPService;
import artifact.Publication;
import artifact.Researcher;

public class App {

	private static MyServiceSOAPService soapService;
	private static MyServiceSOAP soap;

	private static Client client;
	private static WebTarget target;
	private static Response response;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		soapService = new MyServiceSOAPService();
		soap = soapService.getMyServiceSOAPPort();
		client = ClientBuilder.newClient();

		boolean exit = false;

		while (!exit) {
			String option = getMenuOption();
			switch (option) {
			case "1":
				getStoredDataAboutResearchers();
				exit = leave();
				break;
			case "2":
				System.out.println("Insert the researcher name:");
				String researcherName = scan.nextLine();
				getStoredDataAboutResearchersByName(researcherName);
				exit = leave();
				break;
			case "3":
				System.out.println("Insert the interest:");
				String interest = scan.nextLine();
				getInfotmationAboutResearchersByInterest(interest);
				exit = leave();
				break;
			case "4":
				getStoredDataAboutPublications();
				exit = leave();
				break;
			case "5":
				System.out.println("Insert the publication title:");
				String publicationTitle = scan.nextLine();
				getStoredDataAboutPublicationsByTitle(publicationTitle);
				exit = leave();
				break;
			case "6":
				System.out.println("Insert the researcher name:");
				researcherName = scan.nextLine();
				getStoredDataAboutPublicationsByAuthor(researcherName);
				exit = leave();
				break;
			case "7":
				System.out.println("Insert the journal name:");
				String journal = scan.nextLine();
				getStoredDataAboutPublicationsByJournal(journal);
				exit = leave();
				break;
			case "8":
				System.out.println("Insert the researcher name:");
				researcherName = scan.nextLine();
				System.out.println("Insert the journal name:");
				journal = scan.nextLine();
				getStoredDataAboutPublicationsByJournalAndAuthor(journal, researcherName);
				exit = leave();
				break;
			case "9":
				System.out.println("Insert the researcher name:");
				String name = scan.nextLine();
				getCitationCountPerYear(name);
				exit = leave();
				break;
			case "10":
				System.out.println("Insert the Institution:");
				String institution = scan.nextLine();
				System.out.println("Insert the period of time (yyyy-yyyy):");

				String date = "";
				boolean yearsCheck = true;
				while (yearsCheck) {
					date = scan.nextLine();
					if (checkYearsFormat(date) == true) {
						if (checkYears(date)[0] == true) {
							if (checkYears(date)[1] == true) {
								yearsCheck = false;
							} else {
								System.out.println(
										"The first year in the time period must be smaller than the second one, try again.");
							}
						} else {
							System.out.println("The years selected must be integers, try again.");
						}
					} else {
						System.out.println(
								"The years in the time period must be in the this format (yyyy-yyyy). Try again");
					}
				}

				String[] years = date.split("-");

				int minYear = Integer.parseInt(years[0]);
				int maxYear = Integer.parseInt(years[1]);

				getPublicationByInstitutionAndYear(institution, minYear, maxYear);
				exit = leave();
				break;
			case "11":
				exit = true;
				break;
			}
		}

	}

	private static boolean leave() {
		System.out.println("\n" + "-".repeat(80) + "\n");
		System.out.println("Do you want to leave? \nPress 'y' to leave or any key to go to the menu.");
		String leave = scan.nextLine();
		boolean exit = false;
		if (leave.contains("y")) {
			exit = true;
		}
		return exit;
	}

	private static String getMenuOption() {
		StringAlignUtils util80 = new StringAlignUtils(80, "CENTER");
		StringAlignUtils util70 = new StringAlignUtils(70, "LEFT");
		StringAlignUtils util10 = new StringAlignUtils(5, "LEFT");

		System.out.println("-".repeat(80));
		System.out.println(util80.format("IS Google Scholar"));
		System.out.println("-".repeat(80) + "\n");
		System.out.println(util80.format("Choose between the options below:") + "\n");
		System.out.println(util10.format("1)") + util70.format("Select all researchers."));
		System.out.println(util10.format("2)") + util70.format("Select a researcher, by name."));
		System.out.println(util10.format("3)")
				+ util70.format("Select an interest, and see all the researchers that share that interest."));
		System.out.println(util10.format("4)") + util70.format("Select all publications."));
		System.out.println(util10.format("5)") + util70.format("Select a publication, by title."));
		System.out.println(
				util10.format("6)") + util70.format("Select a researcher, and see all publications associated."));
		System.out
				.println(util10.format("7)") + util70.format("Select a journal, and see all publications associated."));
		System.out.println(util10.format("8)")
				+ util70.format("Select a researcher and a journal, and see all publications associated."));
		System.out.println(
				util10.format("9)") + util70.format("Select a researcher to obtain her/his citation count per year."));
		System.out.println(util10.format("10)")
				+ util70.format("Select an institution and a year and obtain all publications from that\n"
						+ "     institution that were published during the specified period."));
		System.out.println(util10.format("11)") + util70.format("Exit."));
		System.out.println("\n" + "-".repeat(80) + "\n");
		System.out.print("Option: ");
		String option = scan.nextLine();
		System.out.println("\n" + "-".repeat(80) + "\n");
		return option;
	}

	private static void printResearcherData(List<Researcher> researchersList) {
		for (Researcher researcher : researchersList) {
			System.out.print("--> Name: " + researcher.getName() + " | Affiliation: " + researcher.getAffiliation()
					+ " | Interests: " + researcher.getInterest().get(0));
			for (int i = 1; i < researcher.getInterest().size(); i++) {
				System.out.print(", " + researcher.getInterest().get(i));
			}
			System.out.println("\n\n");
		}
	}

	private static void printPublicationsData(List<Publication> publicationsList) {

		StringAlignUtils util80 = new StringAlignUtils(100, "LEFT");
		StringAlignUtils utilc = new StringAlignUtils(100, "CENTER");
		StringAlignUtils util60 = new StringAlignUtils(80, "LEFT");
		StringAlignUtils util20 = new StringAlignUtils(20, "RIGHT");

		System.out.println("\n" + ".".repeat(100) + "\n");
		System.out.println(utilc.format("PUBLICATIONS"));
		System.out.println(".".repeat(100) + "\n");

		for (Publication publication : publicationsList) {

			String str = "";

			System.out.println("\n" + util80.format(publication.getTitle()));
			System.out.print(util20.format("Authors:  "));
			for (int i = 0; i < publication.getAuthors().size(); i++) {
				str = str + publication.getAuthors().get(i) + ",";
			}
			System.out.println(util60.format(str));
			System.out.println(util20.format("Publication Date:  ") + util60.format(publication.getPublicationDate()));
			System.out.println(util20.format("Newsletter:  ") + util60.format(publication.getNewsletter()));
			System.out.println(util20.format("Edition:  ") + util60.format(publication.getEdition()));
			System.out.println(util20.format("Pages:  ") + util60.format(publication.getPages()));
			System.out.println(util20.format("Total citations:  ") + util60.format(publication.getTotalCitation()));
			System.out.println("\n");
			System.out.println(".".repeat(100) + "\n");
		}

	}

	private static void getStoredDataAboutResearchers() {
		List<Researcher> researchersList = soap.getInfotmationAboutResearchers();
		if (researchersList.size() == 0) {
			System.out.println("\nThere are no researchers stored.");
		} else {
			printResearcherData(researchersList);
		}
	}

	private static void getStoredDataAboutResearchersByName(String researcherName) {
		List<Researcher> researchersList = soap.getInfotmationAboutResearchersByName(researcherName);
		if (researchersList.size() == 0) {
			System.out.println("\nThere are no researchers stored with the given name.");
		} else {
			printResearcherData(researchersList);
		}
	}

	private static void getInfotmationAboutResearchersByInterest(String researcherInterest) {
		List<Researcher> researchersList = soap.getInfotmationAboutResearchersByInterest(researcherInterest);
		if (researchersList.size() == 0) {
			System.out.println("\nThere are no researchers stored with the given interest.");
		} else {
			printResearcherData(researchersList);
		}
	}

	private static void getStoredDataAboutPublications() {
		target = client.target("http://localhost:8080/rest/services/myservice/all");
		response = target.request().get();
		List<Publication> publicationList = (List<Publication>) response
				.readEntity(new GenericType<List<Publication>>() {
				});

		if (publicationList.size() == 0) {
			System.out.println("\nThere are no publications stored.");
		} else {
			printPublicationsData(publicationList);
		}
	}

	private static void getStoredDataAboutPublicationsByTitle(String publicationTitle) {
		target = client.target("http://localhost:8080/rest/services/myservice/title");
		target = target.queryParam("publicationTitle", publicationTitle);
		response = target.request().get();
		List<Publication> publicationList = (List<Publication>) response
				.readEntity(new GenericType<List<Publication>>() {
				});

		if (publicationList.size() == 0) {
			System.out.println("\nThere are no publications stored with the given title.");
		} else {
			printPublicationsData(publicationList);
		}
	}

	private static void getStoredDataAboutPublicationsByAuthor(String researcherName) {
		target = client.target("http://localhost:8080/rest/services/myservice/author");
		target = target.queryParam("authorName", researcherName);
		response = target.request().get();
		List<Publication> publicationList = (List<Publication>) response
				.readEntity(new GenericType<List<Publication>>() {
				});

		if (publicationList.size() == 0) {
			System.out.println("\nThere are no publications stored for the given researcher.");
		} else {
			printPublicationsData(publicationList);
		}
	}

	private static void getStoredDataAboutPublicationsByJournal(String journal) {
		target = client.target("http://localhost:8080/rest/services/myservice/journal");
		target = target.queryParam("newsletterName", journal);
		response = target.request().get();
		List<Publication> publicationList = (List<Publication>) response
				.readEntity(new GenericType<List<Publication>>() {
				});

		if (publicationList.size() == 0) {
			System.out.println(
					"\nThere are no publications stored that were published in the given journal or conference.");
		} else {
			printPublicationsData(publicationList);
		}
	}

	private static void getStoredDataAboutPublicationsByJournalAndAuthor(String journal, String author) {
		target = client.target("http://localhost:8080/rest/services/myservice/authorandjournal");
		target = target.queryParam("newsletterName", journal).queryParam("authorName", author);
		response = target.request().get();
		List<Publication> publicationList = (List<Publication>) response
				.readEntity(new GenericType<List<Publication>>() {
				});

		if (publicationList.size() == 0) {
			System.out.println("\nThere are no publications stored.");
		} else {
			printPublicationsData(publicationList);
		}
	}

	private static void getCitationCountPerYear(String researcherName) throws IOException {
		List<Researcher> researchersList = soap.getInfotmationAboutResearchersByName(researcherName);
		String name = "";

		if (researchersList.size() == 0) {
			System.out.println("\nThere are no researchers stored with the given name.");
		} else {
			name = researchersList.get(0).getName();

			target = client.target("http://localhost:8080/rest/services/myservice/author");
			target = target.queryParam("authorName", name);
			response = target.request().get();
			List<Publication> publicationsList = response.readEntity(new GenericType<List<Publication>>() {
			});

			TreeMap<Integer, Integer> citationCountPerYear = new TreeMap<Integer, Integer>();// <year, citation>

			if (publicationsList.size() == 0) {
				System.out.println("\nThere are no publication stored for that researcher name.");
			} else {
				for (Publication publication : publicationsList) {
					int year = publication.getPublicationDate();
					int citation = publication.getTotalCitation();

					if (citationCountPerYear.containsKey(year) == true) {
						int totalCitation = citation + citationCountPerYear.get(year);
						citationCountPerYear.put(year, totalCitation);
					} else {
						citationCountPerYear.put(year, citation);
					}
				}
				System.out.println("\nCitation count per year for " + name + ": ");
				for (Entry<Integer, Integer> entry : citationCountPerYear.entrySet()) {
					System.out.println("\nIn " + entry.getKey() + " the citation count was " + entry.getValue() + ".");
				}
			}
			response.close();
		}
		
	}

	private static List<Publication> getPublicationByInstitutionAndYear(String institution, int minYear, int maxYear) {

		List<Researcher> researchers = soap.getInfotmationAboutResearchers();

		List<Researcher> researchersInstitution = new ArrayList<>();

		HashMap<String, Publication> titlesAndPublications = new HashMap<String, Publication>();

		for (Researcher researcher : researchers) {
			if (researcher.getAffiliation().toLowerCase().contains(institution.toLowerCase())) {
				researchersInstitution.add(researcher);
				target = client.target("http://localhost:8080/rest/services/myservice/author");
				target = target.queryParam("authorName", researcher.getName());
				response = target.request().get();
				List<Publication> publicationsPerResearcher = (List<Publication>) response
						.readEntity(new GenericType<List<Publication>>() {
						});
				for (Publication pub : publicationsPerResearcher) {
					titlesAndPublications.put(pub.getTitle(), pub);
				}
			}
		}
		List<Publication> publications = new ArrayList<Publication>(titlesAndPublications.values());

		for (Publication publication : publications) {
			if (publication.getPublicationDate() < minYear || publication.getPublicationDate() > maxYear) {
				publications.remove(publication);
			}
		}

		if (publications.size() == 0) {
			System.out.println(
					"\nThere are no publications stored for the given intitution during the given period of time.");
		} else {
			printPublicationsData(publications);
		}

		return publications;

	}

	private static boolean checkYearsFormat(String years) {

		String[] yearsSplit = years.split("-");
		boolean check;

		if (yearsSplit.length == 2) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	private static boolean[] checkYears(String years) {

		String[] yearsSplit = years.split("-");

		boolean[] check = { true, true };

		for (int i = 0; i < yearsSplit.length; i++) {
			if (isInteger(yearsSplit[i]) == false) {
				check[0] = false;
			}
		}

		if (yearsSplit.length == 2) {
			if (check[0] == true && Integer.parseInt(yearsSplit[0]) > Integer.parseInt(yearsSplit[1])) {
				check[1] = false;
			}
		}

		return check;
	}

	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}