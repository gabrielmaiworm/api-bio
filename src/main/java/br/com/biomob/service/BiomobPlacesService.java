package br.com.biomob.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biomob.entity.Evaluation;
import br.com.biomob.interfaces.IBiomobPlacesService;
import br.com.biomob.interfaces.IGooglePlacesRestClientService;
import br.com.biomob.model.BiomobPlacesReturn;
import br.com.biomob.model.Categories;
import br.com.biomob.model.Place;
import br.com.biomob.model.google.GoogleResponse;
import br.com.biomob.model.google.GoogleResult;
import br.com.biomob.repository.EvaluationRepository;

@Service
public class BiomobPlacesService implements IBiomobPlacesService{
	
	private static final String ALL_CATEGORIES = "ALL_CATEGORIES";
	
	@Autowired
	IGooglePlacesRestClientService iGooglePlacesRestClientService;

//	@Autowired
//	private BiomobRepository biomobRepository;
	
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@Override
	public BiomobPlacesReturn findPlacesByGeoreference(String category, String latitude, String longitude, String range) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		List<String> categories = generateCategoryList(category);
		
		for (String categoryValue : categories) {
			GoogleResponse googleResponse = iGooglePlacesRestClientService.findPlaces(categoryValue, latitude, longitude, range);
			biomobPlacesReturn = toBiomobPlacesReturn(googleResponse);
		}
		
		return biomobPlacesReturn;
	}

	@Override
	public BiomobPlacesReturn nextPage(String actualPage, String nextPageToken) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		GoogleResponse googleResponse = iGooglePlacesRestClientService.nextPage(actualPage, nextPageToken);
		biomobPlacesReturn = toBiomobPlacesReturn(googleResponse);
		
		return biomobPlacesReturn;
	}

	private List<String> generateCategoryList(String category) {
		
		List<String> categories = new ArrayList<>();
		
		if (category != null && category.equals(ALL_CATEGORIES)) {
			
			for (Categories categoryValue : Categories.values()) {
				
				if (categoryValue.equals(Categories.ALL_CATEGORIES)) {
					continue;
				}
				
				categories.add(categoryValue.toString());
			}
			
			return categories;
		}
		
		categories.add(category);
		
		return categories;
	}

	private BiomobPlacesReturn toBiomobPlacesReturn(GoogleResponse googleResponse) {
		
		BiomobPlacesReturn biomobPlacesReturn = new BiomobPlacesReturn();
		
		for (GoogleResult result : googleResponse.getResults()) {
			Place place = new Place();
			place.setGoogleFields(result);
			
			place.setBiomobEvaluation(findBiomobEvaluation(result.getPlace_id()));
			
			place.setBiomobStarAverage(starAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobCirculacaoAverage(circulacaoAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobEstacionamentoAverage(estacionamentoAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobCalcadaAverage(calcadaAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobAudioVisualAverage(audioVisualAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobEntradaAverage(entradaAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobBanheiroAverage(banheiroAverageCalculator(place.getBiomobEvaluation()));
			
			place.setBiomobCirculacaoCount(circulacaoCount(place.getBiomobEvaluation()));
			
			place.setBiomobEstacionamentoCount(estacionamentoCount(place.getBiomobEvaluation()));
			
			place.setBiomobCalcadaCount(calcadaCount(place.getBiomobEvaluation()));
			
			place.setBiomobBanheiroCount(banheiroCount(place.getBiomobEvaluation()));
			
			place.setBiomobEntradaCount(entradaCount(place.getBiomobEvaluation()));
			
			place.setBiomobAudioVisualCount(audioVisualCount(place.getBiomobEvaluation()));
			
			
			biomobPlacesReturn.getPlaces().add(place);
		}
		
		biomobPlacesReturn.getPage().setActualPageUrl(googleResponse.getActualPageUrl());
		biomobPlacesReturn.getPage().setNextPageToken(googleResponse.getNext_page_token());
		
		return biomobPlacesReturn;
	}
	
	private Double circulacaoCount(List<Evaluation> biomobCirculacaoCount) {
		int contadorNA = 0;
		int contadorCirculacao = 0;

			for ( Evaluation evaluation : biomobCirculacaoCount) {
				var a = evaluation.getCirculacaoInterna();
				var b = evaluation.isCirculacaoInternaNA();
				
				if (a == 1 || a == 5) {
					contadorCirculacao++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorCirculacao) {
				return 2.0;
			} else {
				return 1.0;
			}
	}
	
	private Double estacionamentoCount(List<Evaluation> biomobEstacionamentoCount) {
		int contadorNA = 0;
		int contadorEstacionamento = 0;

			for ( Evaluation evaluation : biomobEstacionamentoCount) {
				var a = evaluation.getEstacionamento();
				var b = evaluation.isEstacionamentoNA();
				
				if (a == 1 || a == 5) {
					contadorEstacionamento++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorEstacionamento) {
				return 2.0;
			} else {
				return 1.0;
			}
	}
	
	private Double calcadaCount(List<Evaluation> biomobCalcadaCount) {
		int contadorNA = 0;
		int contadorCalcada = 0;

			for ( Evaluation evaluation : biomobCalcadaCount) {
				var a = evaluation.getCalcada();
				var b = evaluation.isCalcadaNA();
				
				if (a == 1 || a == 5) {
					contadorCalcada++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorCalcada) {
				return 2.0;
			} else {
				return 1.0;
			}
	}
	
	private Double audioVisualCount(List<Evaluation> biomobAudioVisualCount) {
		int contadorNA = 0;
		int contadorAudioVisual = 0;

			for ( Evaluation evaluation : biomobAudioVisualCount) {
				var a = evaluation.getAudioVisual();
				var b = evaluation.isAudioVisualNA();
				
				if (a == 1 || a == 5) {
					contadorAudioVisual++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorAudioVisual) {
				return 2.0;
			} else {
				return 1.0;
			}
	}
	
	private Double entradaCount(List<Evaluation> biomobEntradaCount) {
		int contadorNA = 0;
		int contadorEntrada = 0;

			for ( Evaluation evaluation : biomobEntradaCount) {
				var a = evaluation.getEntradaPrincipal();
				var b = evaluation.isEntradaPrincipalNA();
				
				if (a == 1 || a == 5) {
					contadorEntrada++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorEntrada) {
				return 2.0;
			} else {
				return 1.0;
			}
	}
	
	private Double banheiroCount(List<Evaluation> biomobBanheiroCount) {
		int contadorNA = 0;
		int contadorBanheiroAcessivel = 0;

			for ( Evaluation evaluation : biomobBanheiroCount) {
				var a = evaluation.getBanheiroAcessivel();
				var b = evaluation.isBanheiroAcessivelNA();
				
				if (a == 1 || a == 5) {
					contadorBanheiroAcessivel++;
				}
				
				if (b) {
					contadorNA++;
				}

			}
			if (contadorNA >= contadorBanheiroAcessivel) {
				return 2.0;
			} else {
				return 1.0;
			}
	}

	private Double starAverageCalculator(List<Evaluation> biomobEvaluation) {
		
		int count = 0;
		double total = 0;
		
		for (Evaluation evaluation : biomobEvaluation) {
			count++;
			total = total + evaluation.getStar();
			
		}

		DecimalFormat formato = new DecimalFormat("#.##");      
		

		if (count == 0) {
			return null; 
		}
		
		else if(total == 0) {
			return null;
			
		} else {
		
		
		String average = String.valueOf(total / count);
		
		return Double.valueOf(average.substring(0, 3));
		}
	}
	
	private Double circulacaoAverageCalculator(List<Evaluation> biomobCirculacao) {
		
		int count = 0;
		double total = 0;
		
		for (Evaluation evaluation : biomobCirculacao) {
			
			if(evaluation.getCirculacaoInterna() > 0) {
				count++;
				total = total + evaluation.getCirculacaoInterna();
			}
		}
		

		DecimalFormat formato = new DecimalFormat("#.##");      
		

		if (count == 0) {
			return null; 
		} else {
		
		String average = String.valueOf(total / count);
		
		return Double.valueOf(average.substring(0, 3));
		}
	}
	
private Double estacionamentoAverageCalculator(List<Evaluation> biomobEstacionamento) {
		
		int count = 0;
		double total = 0;
		
		for (Evaluation evaluation : biomobEstacionamento) {
			if(evaluation.getEstacionamento() > 0) {
				count++;
				total = total + evaluation.getEstacionamento();
			}
			
			
		}

		DecimalFormat formato = new DecimalFormat("#.##");      
		

		if (count == 0) {
			return null; 
		} else {
		
		
		String average = String.valueOf(total / count);
		
		return Double.valueOf(average.substring(0, 3));
		}
	}

private Double calcadaAverageCalculator(List<Evaluation> biomobCalcada) {
	
	int count = 0;
	double total = 0;
	
	for (Evaluation evaluation : biomobCalcada) {
		if(evaluation.getCalcada() > 0) {
			count++;
			total = total + evaluation.getCalcada();
		}
	}

	DecimalFormat formato = new DecimalFormat("#.##");      
	

	if (count == 0) {
		return null; 
	} else {

	String average = String.valueOf(total / count);
	
	return Double.valueOf(average.substring(0, 3));
	}
}

private Double audioVisualAverageCalculator(List<Evaluation> biomobAudioVisual) {
	
	int count = 0;
	double total = 0;
	
	for (Evaluation evaluation : biomobAudioVisual) {
		if(evaluation.getAudioVisual() > 0) {
			count++;
			total = total + evaluation.getAudioVisual();
		}
		
	}

	DecimalFormat formato = new DecimalFormat("#.##");      
	

	if (count == 0) {
		return null; 
	} else {

	String average = String.valueOf(total / count);
	
	return Double.valueOf(average.substring(0, 3));
	}
}

	private Double entradaAverageCalculator(List<Evaluation> biomobEntrada) {
	
		int count = 0;
		double total = 0;
		
		for (Evaluation evaluation : biomobEntrada) {
			if(evaluation.getEntradaPrincipal() > 0) {
				count++;
				total = total + evaluation.getEntradaPrincipal();
			}
			
			
		}

	DecimalFormat formato = new DecimalFormat("#.##");      
	

	if (count == 0) {
		return null; 
	} else {
	
	String average = String.valueOf(total / count);
	
	return Double.valueOf(average.substring(0, 3));
	}
}

private Double banheiroAverageCalculator(List<Evaluation> biomobBanheiro) {
	
	int count = 0;
	double total = 0;
	
	for (Evaluation evaluation : biomobBanheiro) {
		if(evaluation.getBanheiroAcessivel() > 0) {
			count++;
			total = total + evaluation.getBanheiroAcessivel();
		}

		
	}

	DecimalFormat formato = new DecimalFormat("#.##");      
	

	if (count == 0) {
		return null; 
	} else {
	
	String average = String.valueOf(total / count);
	
	return Double.valueOf(average.substring(0, 3));
	}
}
		

	private List<Evaluation> findBiomobEvaluation(String place_id) {
		return evaluationRepository.findByPlaceId(place_id);
	}

}
