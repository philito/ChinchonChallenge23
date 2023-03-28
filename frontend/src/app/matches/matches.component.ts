import { Component } from "@angular/core";
import { Match } from "../../model/match";
import { MatchService } from "../../services/MatchService";

@Component({
  selector: "app-matches",
  templateUrl: "./matches.component.html",
  styleUrls: ["./matches.component.scss"]
})
export class MatchesComponent {

  matches: Match[] = [];

  displayedColumns: string[] = ["id", "players", "full"];

  constructor(
    private matchService: MatchService
  ) {}

  ngOnInit(): void {
    this.getMatches();
  }

  getMatches(): void {
    this.matchService.getMatches()
      .subscribe(matches => this.matches = matches);
  }

}
